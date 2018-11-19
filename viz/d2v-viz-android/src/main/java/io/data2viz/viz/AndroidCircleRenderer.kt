package io.data2viz.viz

import android.graphics.*


fun CircleNode.render(renderer: AndroidCanvasRenderer) {
	val canvas = renderer.canvas
	with(renderer) {
		style.fill?.let {
			paint.style = Paint.Style.FILL
			it.updatePaint(paint, renderer)
			canvas.drawCircle(
				x.dp,
				y.dp,
				radius.dp,
				paint)
		}
		style.stroke?.let {
			paint.style = Paint.Style.STROKE
			it.updatePaint(paint, renderer)
			canvas.drawCircle(
				x.dp,
				y.dp,
				radius.dp,
				paint)
		}
	}
}
