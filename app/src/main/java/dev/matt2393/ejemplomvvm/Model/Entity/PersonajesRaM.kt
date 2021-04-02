package dev.matt2393.ejemplomvvm.Model.Entity

data class PersonajesRaM(
    val info: Info = Info(),
    val results: List<Result> = arrayListOf()
) {
    data class Info(
        val count: Int = 0,
        val next: String = "",
        val pages: Int = 0,
        val prev: String? = null
    )

    data class Result(
        val created: String = "",
        val episode: List<String> = arrayListOf(),
        val gender: String = "",
        val id: Int = 0,
        val image: String = "",
        val location: Location = Location(),
        val name: String = "",
        val origin: Origin = Origin(),
        val species: String = "",
        val status: String = "",
        val type: String = "",
        val url: String = ""
    ) {
        data class Location(
            val name: String = "",
            val url: String = ""
        )

        data class Origin(
            val name: String = "",
            val url: String = ""
        )
    }
}