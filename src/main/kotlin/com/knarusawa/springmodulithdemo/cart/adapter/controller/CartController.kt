package com.knarusawa.springmodulithdemo.cart.adapter.controller

import com.knarusawa.springmodulithdemo.auth.adapter.exception.UnauthorizedException
import com.knarusawa.springmodulithdemo.cart.adapter.dto.ApiV1CartGetResponse
import com.knarusawa.springmodulithdemo.cart.adapter.dto.ApiV1CartPostRequest
import com.knarusawa.springmodulithdemo.cart.application.addCartItem.AddCartItemInputData
import com.knarusawa.springmodulithdemo.cart.application.addCartItem.AddCartItemService
import com.knarusawa.springmodulithdemo.cart.application.query.CartDtoQueryService
import org.springframework.http.HttpStatus
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/cart")
class CartController(
        private val cartDtoQueryService: CartDtoQueryService,
        private val addCartItemService: AddCartItemService,
) {
    @GetMapping
    fun apiV1CartGet(
            @AuthenticationPrincipal principal: OAuth2AuthenticatedPrincipal
    ): ApiV1CartGetResponse {
        val userId = principal.getAttribute<String?>("sub")
                ?: throw UnauthorizedException()

        val cart = cartDtoQueryService.findByUserId(userId)
                ?: return ApiV1CartGetResponse(null)

        return ApiV1CartGetResponse(
                cart = ApiV1CartGetResponse.Cart(
                        cartId = cart.cartId,
                        userId = cart.userId,
                        items = cart.items.map {
                            ApiV1CartGetResponse.Cart.Item(itemId = it.itemId, quantity = it.quantity)
                        }
                )

        )
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun apiV1CartPost(
            @RequestBody apiV1CartPostRequest: ApiV1CartPostRequest,
            @AuthenticationPrincipal principal: OAuth2AuthenticatedPrincipal
    ) {
        val userId = principal.getAttribute<String?>("sub")
                ?: throw UnauthorizedException()

        val inputData = AddCartItemInputData.of(
                userId = userId,
                itemId = apiV1CartPostRequest.itemId,
                quantity = apiV1CartPostRequest.quantity
        )
        
        addCartItemService.exec(inputData)
    }
}