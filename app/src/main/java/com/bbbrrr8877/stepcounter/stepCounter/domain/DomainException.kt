package com.bbbrrr8877.stepcounter.stepCounter.domain

abstract class DomainException : IllegalStateException() {

    class SensorHasNoPermission : DomainException()
}