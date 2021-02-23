package app.motsu.hiromoto.la_bookshelf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_show_detail.*

class ShowDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)

        val selectBookIndex = intent.getIntExtra("position",-1)
        if(selectBookIndex  == -1){
            finish()
            return
        }
        val showBook: Book = MainActivity.bookList.get(selectBookIndex)

        detail_TitleTextView.text = showBook.title
        detail_AuthorTextView.text = if(showBook.author == "") "unknown" else showBook.author
        detail_PriceTextView.text = if (showBook.price == 0) "-" else showBook.price.toString()
        detail_ContentTextView.text = showBook.detail

        detail_BackButton.setOnClickListener { finish()}

        detail_RefactButton.setOnClickListener {
            // 編集画面へ遷移


            finish()
        }

        detail_DeleteButton.setOnClickListener {
            // 確認のダイアログ

        }
    }
}