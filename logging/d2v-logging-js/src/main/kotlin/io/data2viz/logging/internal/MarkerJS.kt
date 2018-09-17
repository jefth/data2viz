package io.data2viz.logging.internal

import io.data2viz.logging.Marker

internal class MarkerJS(private val name: String) : Marker {

    override fun getName(): String = this.name
}