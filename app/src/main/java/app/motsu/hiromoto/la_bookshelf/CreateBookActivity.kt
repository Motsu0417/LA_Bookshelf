package app.motsu.hiromoto.la_bookshelf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_book.*

class CreateBookActivity : AppCompatActivity() {

    private var title = ""
    private var author = ""
    private var price = 0
    private var content = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_book)

        create_addButton.setOnClickListener{
            if(create_TitileEditText.text.toString() == ""){
                Toast.makeText(this,"タイトルを入力してください",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            title = create_TitileEditText.text.toString()
            author = create_AuthorEditText.text.toString()

            if(create_PriceEditText.text.toString() == "") {
                price = 0
            }else{
                price = Integer.parseInt(create_PriceEditText.text.toString())
            }

            content = create_ContextEditText.text.toString()
            val newbook = Book(title,author,price,content,0,"")
            MainActivity.bookList.add(newbook)
            setResult(RESULT_OK,intent)
            finish()
        }
    }
}