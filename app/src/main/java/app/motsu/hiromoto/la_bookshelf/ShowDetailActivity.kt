package app.motsu.hiromoto.la_bookshelf

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_show_detail.*

class ShowDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)

        val selectBookIndex = intent.getIntExtra("position", -1)
        if (selectBookIndex == -1) {
            finish()
            return
        }
        val showBook: Book = MainActivity.bookList[selectBookIndex]

        detail_TitleTextView.text = showBook.title
        detail_AuthorTextView.text = if (showBook.author == "") "unknown" else showBook.author
        detail_PriceTextView.text = if (showBook.price == 0) "-" else showBook.price.toString()
        detail_ContentTextView.text = showBook.detail

        detail_BackButton.setOnClickListener { finish() }

        detail_RefactButton.setOnClickListener {
            // 編集画面へ遷移
            val intent = Intent(this, ChangeDetailActivity::class.java)
            intent.putExtra("position", selectBookIndex)
            startActivityForResult(intent, 987)

            //finish()
        }

        detail_DeleteButton.setOnClickListener {
            // 確認のダイアログ
            AlertDialog.Builder(this)
                .setTitle("本の削除")
                .setMessage(showBook.title + " を削除しますか？")
                .setPositiveButton("OK", { dialog, which ->
                    MainActivity.bookList.removeAt(selectBookIndex)
                    val intent = Intent(this, MainActivity::class.java)
                    setResult(9999, intent)
                    finish()
                })
                .setNegativeButton("CANCEL", { dialog, which ->
                    finish()
                }).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // 編集画面から戻ってきたとき
        val intent = Intent(this, MainActivity::class.java)
        setResult(9999, intent)
        finish()
    }
}