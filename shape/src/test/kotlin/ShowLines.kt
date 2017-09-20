import curve.Linear
import curve.Point
import io.data2viz.path.CanvasDrawContext
import io.data2viz.path.PathAdapter
import io.data2viz.path.SvgPath
import io.data2viz.shape.Curve
import io.data2viz.shape.curves
import io.data2viz.shape.line
import org.w3c.dom.CanvasRenderingContext2D
import org.w3c.dom.Element
import org.w3c.dom.HTMLCanvasElement
import kotlin.browser.document
import kotlin.dom.appendElement


val lineGenerator = line<Point> {
    x = { it.x.toDouble() }
    y = { it.y.toDouble() }
}

val points = arrayOf(Point(0,0), Point(50, 50), Point(100,0), Point(150, 100), Point(200,0))


@JsName("showLines")
fun showLines() {
    render("Linear", curves.linear)
    render("LinearClosed", curves.linearClosed)
}

fun render(title: String, curve: (PathAdapter) -> Curve) {
    document.body!!.appendElement("h2") {
        textContent = title
    }
    lineGenerator.curve = curve
    renderCanvas()
    renderSvg()
}

fun renderCanvas() {

    with(newCanvas().getContext("2d") as CanvasRenderingContext2D) {
        beginPath()
        beginPath();
        lineWidth = 1.0;
        strokeStyle = "steelblue";
        lineGenerator.line(points, CanvasDrawContext(this))
        stroke();
    }
}

fun newCanvas(): HTMLCanvasElement {
    val canvas = document.createElement("canvas") as HTMLCanvasElement
    val context = canvas.getContext("2d") as CanvasRenderingContext2D
    context.canvas.width  = 200
    context.canvas.height = 200;
    document.body!!.appendChild(canvas)
    return canvas
}

private fun renderSvg() {
    with(document.body!!) {
        appendChild(createSvgElement("svg").apply {
            setAttribute("width", "200")
            setAttribute("height", "200")
            setAttribute("stroke", "black")
            setAttribute("fill", "none")
            appendChild(createSvgElement("path").apply {
                val line = lineGenerator.line(points, SvgPath()).path
                setAttribute("d", line)
            })
        })
    }
}

fun createSvgElement(name: String): Element {
    val namespaceSvg = "http://www.w3.org/2000/svg"
    return document.createElementNS(namespaceSvg, name)
}

