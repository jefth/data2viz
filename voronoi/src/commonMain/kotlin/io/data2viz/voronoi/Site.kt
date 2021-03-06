/*
 * Copyright (c) 2018-2019. data2viz sàrl.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package io.data2viz.voronoi

import io.data2viz.geom.Point

public class Site(
    public val pos: Point,
    public val index: Int) : Comparable<Site> {

    public val x: Double
        get() = pos.x

    public val y: Double
        get() = pos.y

    override fun compareTo(other: Site): Int = when {
        other.pos.y < pos.y -> -1
        other.pos.y > pos.y -> 1
        other.pos.x < pos.x -> -1
        other.pos.x > pos.x -> 1
        else -> 0
    }

    override fun toString(): String {
        return "Site(pos=$pos, index=$index)"
    }

}
