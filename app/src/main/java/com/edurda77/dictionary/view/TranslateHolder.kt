import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.dictionary.R
import com.edurda77.dictionary.model.data.datasource.WordTranslate

class TranslateHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_translate, parent, false)) {
    private var textItem: TextView? = null
    private var translateItem: TextView? = null

    init {
        textItem = itemView.findViewById(R.id.text_item)
        translateItem = itemView.findViewById(R.id.translate_item)
    }

    @SuppressLint("SetTextI18n")
    fun bind(wordTranslate: WordTranslate) {
        textItem?.text = wordTranslate.text
        wordTranslate.meanings.forEach {
            translateItem?.text = translateItem?.text.toString()+it.translation.textTranslation + ", "
        }
        //translateItem?.text = wordTranslate.text

    }
}