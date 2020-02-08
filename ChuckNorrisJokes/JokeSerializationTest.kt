package com.gopro.chucknorrisjokes

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import org.junit.Assert
import org.junit.Test


/**
 * /!\ THIS FILE MUST NOT BE EDITED /!\
 */
class JokeSerializationTest {
    private val baseJson =
        """{"icon_url":"https://assets.chucknorris.host/img/avatar/chuck-norris.png","id":"kvbADxuyS36ug4MJ7KMBMA","url":"https://api.chucknorris.io/jokes/kvbADxuyS36ug4MJ7KMBMA","value":"Chuck Norris puts mustard gas on his hotdogs."}"""

    private val baseJoke = Joke(
        iconUrl = "https://assets.chucknorris.host/img/avatar/chuck-norris.png",
        id = "kvbADxuyS36ug4MJ7KMBMA",
        url = "https://api.chucknorris.io/jokes/kvbADxuyS36ug4MJ7KMBMA",
        value = "Chuck Norris puts mustard gas on his hotdogs."
    )

    @Test
    fun `serialization is correct`() {
        val json = Json(JsonConfiguration.Stable).stringify(Joke.serializer(), baseJoke)
        Assert.assertEquals(baseJson, json)
    }

    @Test
    fun `deserialization is correct`() {
        val joke = Json(JsonConfiguration.Stable).parse(Joke.serializer(), baseJson)
        Assert.assertEquals(baseJoke, joke)
    }
}
