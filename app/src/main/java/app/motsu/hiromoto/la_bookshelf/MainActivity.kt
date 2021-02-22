package app.motsu.hiromoto.la_bookshelf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val bookList: ArrayList<Book> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            newBookButton.setOnClickListener {
            val intent = Intent(this,CreateBookActivity::class.java)
            startActivityForResult(intent,9)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode != 9 || data == null){
            return
        }

        val title = data.getStringExtra("title")
        val author = data.getStringExtra("author")
        val price = data.getIntExtra("price",0)
        val context = data.getStringExtra("context")

        val newbook = Book(title,author,price,context,0,"")
        bookList.add(newbook)
        Log.d("addBook", bookList.size.toString())
    }

}