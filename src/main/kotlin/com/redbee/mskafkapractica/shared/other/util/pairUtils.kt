package com.redbee.mskafkapractica.shared.other.util

fun <T, S> T.pairedWith(second: S) =
    this to second
