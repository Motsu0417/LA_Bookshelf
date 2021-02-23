package app.motsu.hiromoto.la_bookshelf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_change_detail.*
import kotlinx.android.synthetic.main.activity_create_book.*
import kotlinx.android.synthetic.main.activity_show_detail.*

class ChangeDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_detail)

        Log.d("here","jey")
        val selectBookIndex = intent.getIntExtra("position",-1)
        Log.d("here", "index = " + selectBookIndex)
        if(selectBookIndex  == -1){
            finish()
            return
        }

        val showBook: Book = MainActivity.bookList[selectBookIndex]

        change_title.setText(showBook.title)
        change_author.setText(showBook.author)
        change_price.setText(showBook.price.toString())
        change_content.setText(showBook.detail)

        change_ChangeButton.setOnClickListener{
            var title = ""
            var author = ""
            var price = 0
            var content = ""

            if(change_title.text.toString() == ""){
                Toast.makeText(this,"タイトルを入力してください", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            title = change_title.text.toString()
            author = change_author.text.toString()

            if(change_price.toString() == "") {
                price = 0
            }else{
                price = Integer.parseInt(change_price.text.toString())
            }
            content = change_content.text.toString()

            val newbook = Book(title,author,price,content,0,"")
            MainActivity.bookList[selectBookIndex] = newbook
            val intent = Intent(this, ShowDetailActivity::class.java)
            setResult(9999,intent)
            finish()
        }

        change_backButton.setOnClickListener{
            finish()
        }
    }
}