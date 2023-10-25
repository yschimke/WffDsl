/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package louis2.wear.wff

import kotlinx.html.*
import kotlinx.html.stream.createHTML
import louis2.wear.wff.clock.*
import louis2.wear.wff.common.*
import louis2.wear.wff.common.variant.ambientVariant
import louis2.wear.wff.samples.simpleDigital

internal class Library {
    fun someLibraryMethod(): Boolean {
        return true
    }
}

context(WatchFaceDsl<T>)
internal fun <T> sampleWatchFace(
    width: Int = 480,
    height: Int = 480
): T = watchFace(width = width, height = height) {
    bitmapFonts {
        bitmapFont(name = "whatever") {
            for (c in 0..9) character(
                name = "$c",
                resource = "whatever/$c.png",
                width = 20,
                height = 30
            )
            word(
                name = "11",
                resource = "whatever/11-fancy.png",
                width = 20 * 2,
                height = 30
            )
        }
    }
    clockType(type = ClockType.DIGITAL)
    previewTime("07:35:15")
    stepGoal(9_000)
    //TODO: Add UserConfigurations
    scene(backgroundColor = 0xFF_000003u) {
        condition { default { condition {  } } }
        group(id = "g1") {
            condition {
                expressions {
                    expression("alwaysTrue", "true")
                }
                compare("alwaysTrue") {
                    group { }
                }
            }
            group(id = "g2") {}
            analogClock {
                ambientVariant(
                    target = "tintColor",
                    value = "#" + "f".repeat(8)
                )
                hourHand(resource = "hands/hour.png") {
                    ambientVariant(
                        target = "resource",
                        value = "hands/hour-ambient.png"
                    )
                }
                minuteHand(resource = "hands/minute.png") {
                    ambientVariant(
                        target = "resource",
                        value = "hands/minute-ambient.png"
                    )
                }
                secondHand(resource = "hands/second.png") {
                    ambientVariant(
                        target = "resource",
                        value = "hands/second-ambient.png"
                    )
                    sweep(frequency = 15)
                    tick(duration = .2f, strength = 1f)
                }
            }
        }
        //TODO: Add ListConfiguration
        //TODO: Add BooleanConfiguration
        //TODO: Add ComplicationSlot
    }
}

context(TagConsumer<T>)
internal fun <T> kotlinxHtmlExample(): T = html {
    body {
        div outerDiv@{
            lol()
            button {
                this@outerDiv.lol()
//                    lol()
            }
        }
        h1 { +"Lol" }
        a(href = "https://jetbrains.com") {
            href = "d.android.com"
        }
    }
}

internal fun main() {
    if (false) with(WatchFaceDsl()) {
        println(sampleWatchFace())
    }
    with(WatchFaceDsl()) {
        println(simpleDigital())
    }
    if (false) with(createHTML(xhtmlCompatible = true)) {
        println(kotlinxHtmlExample())
    }
}

//@HtmlTagMarker
internal fun DIV.lol() {
    +"lol"
}

