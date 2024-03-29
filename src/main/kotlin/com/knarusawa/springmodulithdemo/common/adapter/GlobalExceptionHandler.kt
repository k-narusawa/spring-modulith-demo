package com.knarusawa.springmodulithdemo.common.adapter

import com.knarusawa.springmodulithdemo.common.dto.ErrorResponse
import com.knarusawa.springmodulithdemo.common.util.logger
import jakarta.servlet.http.HttpServletRequest
import org.springframework.boot.logging.LogLevel
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    companion object {
        private val log = logger()
    }

    @ExceptionHandler(Exception::class)
    fun handleException(
            ex: Exception,
            request: HttpServletRequest
    ): ResponseEntity<ErrorResponse> {
        log.error("message: ${ex.message}, cause: ${ex.cause}, ex: $ex")
        log.warn(ex.stackTraceToString())
        return ResponseEntity(
                ErrorResponse.of(
                        exception = ex,
                        errorMessage = ex.message ?: "予期せぬエラーが発生しました",
                        logLevel = LogLevel.ERROR
                ),
                HttpStatus.INTERNAL_SERVER_ERROR
        )
    }
}