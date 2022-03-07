package com.example.kotlinjpapractice.repository

import com.example.kotlinjpapractice.model.dto.order.*
import com.example.kotlinjpapractice.model.entity.*
import com.example.kotlinjpapractice.model.entity.QCustomerUser.*
import com.example.kotlinjpapractice.model.entity.QOrderDelivery.*
import com.example.kotlinjpapractice.model.entity.QProduct.*
import com.example.kotlinjpapractice.model.entity.QProductImage.*
import com.example.kotlinjpapractice.model.entity.QProductOrderDelivery.*
import com.querydsl.jpa.impl.JPAQueryFactory

class ProductOrderDeliveryRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : ProductOrderDeliveryRepositoryCustom {

    private val sizeOption = QProductOption("sizeOption")
    private val colorOption = QProductOption("colorOption")

    override fun findOrderProductList(orderDeliveryId: Long): List<OrderProductListRes> {
        return jpaQueryFactory.select(
                QOrderProductListRes(
                    productImage.path,
                    product.name,
                    sizeOption.optionName,
                    colorOption.optionName,
                    productOrderDelivery.orderAmount,
                    product.price
                )
            ).from(productOrderDelivery)
            .leftJoin(product).on(productOrderDelivery.product.id.eq(product.id))
            .leftJoin(sizeOption).on(sizeOption.id.eq(productOrderDelivery.optionSize.id))
            .leftJoin(colorOption).on(colorOption.id.eq(productOrderDelivery.optionColor.id))
            .leftJoin(productImage).on(productImage.id.eq(product.thumbnailImage.id))
            .where(productOrderDelivery.orderDelivery.id.eq(orderDeliveryId))
            .fetch()
    }

    override fun findOrderAllForCustomer(orderDeliveryId: Long, customerId: Long): CustomerOrderRes? {

        return jpaQueryFactory.select(
                QCustomerOrderRes(
                    orderDelivery.orderNum,
                    customerUser.username,
                    customerUser.loginId,
                    orderDelivery.orderStatus.stringValue()
            )
            ).from(orderDelivery)
            .leftJoin(customerUser).on(orderDelivery.customerUser.id.eq(customerUser.id))
            .where(orderDelivery.id.eq(orderDeliveryId))
            .fetchOne()
    }


    override fun findOrderListForBizUser(shopId: Long): List<BizOrderListRes> {
        return jpaQueryFactory.select(
            QBizOrderListRes(
                orderDelivery.orderNum,
                customerUser.username,
                orderDelivery.orderStatus.stringValue()
            )
        ).distinct().from(productOrderDelivery) // distinct() 중복제거
            .join(orderDelivery).on(orderDelivery.id.eq(productOrderDelivery.orderDelivery.id))
            .join(customerUser).on(customerUser.id.eq(orderDelivery.customerUser.id))
            .join(product).on(product.id.eq(productOrderDelivery.product.id))
            .where(product.shoppingMall.id.eq(shopId))
            .fetch()

    }
}