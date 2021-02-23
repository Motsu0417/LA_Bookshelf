package app.motsu.hiromoto.la_bookshelf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_book.*

class CreateBookActivity : AppCompatActivity() {

    var title = ""
    var author = ""
    var price = 0
    var content = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_book)

        create_addButton.setOnClickListener{
            title = create_TitileEditText.text.toString()
            author = create_AuthorEditText.text.toString()
            price = Integer.parseInt(create_PriceEditText.text.toString())
            content = create_ContextEditText.text.toString()
            val newbook = Book(title,author,price,content,0,"")
            MainActivity.bookList.add(newbook)
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}