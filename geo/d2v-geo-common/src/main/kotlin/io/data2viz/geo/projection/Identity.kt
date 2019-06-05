package io.data2viz.geo.projection

import io.data2viz.geo.geometry.clip.noPostClip
import io.data2viz.geo.geometry.clip.noPreClip
import io.data2viz.geo.projection.common.*
import io.data2viz.math.PI


/**
 * Projections without any transformations and clipping
 */
fun identityProjection(init: Projection.() -> Unit = {}) =
    projection(IdentityProjection()) {
        preClip = noPreClip
        postClip = noPostClip
        scale = 180 / PI
        init()
    }

internal class IdentityProjection : NoCommonCalculationsProjector {

    override fun projectLambda(lambda: Double, phi: Double): Double = lambda
    override fun projectPhi(lambda: Double, phi: Double): Double = phi
    override fun invertLambda(lambda: Double, phi: Double): Double = lambda
    override fun invertPhi(lambda: Double, phi: Double): Double = phi

}