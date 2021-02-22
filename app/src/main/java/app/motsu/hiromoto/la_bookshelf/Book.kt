package app.motsu.hiromoto.la_bookshelf

data class Book(
    var name : String? = "",
    var author: String? = "",
    var price: Int? = 0,
    var detail: String? = "",
    var time_update:Int = 0,
    var imageUrl: String? = ""
)