package app.motsu.hiromoto.la_bookshelf

data class Book(
    var name : String?,
    var author: String?,
    var price: Int?,
    var detail: String?,
    var time_update:Int,
    var imageUrl: String?
)