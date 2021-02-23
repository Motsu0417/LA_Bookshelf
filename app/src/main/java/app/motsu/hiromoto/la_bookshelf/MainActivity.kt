package app.motsu.hiromoto.la_bookshelf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        val bookList: ArrayList<Book> = ArrayList()
    }
    val adapter = BookShelfAdapter(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        newBookButton.setOnClickListener {
            val intent = Intent(this,CreateBookActivity::class.java)
            startActivityForResult(intent,9)
        }


        bookShelfView.layoutManager = LinearLayoutManager(this)
        bookShelfView.adapter = adapter

        adapter.addAll(bookList)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // 新規作成画面から戻ってきたとき
        if(requestCode != 9 || data == null){
            return
        }
        Log.d("addBook", bookList.size.toString())
        adapter.clear()
        adapter.addAll(bookList)
        adapter.notifyDataSetChanged()
    }

}