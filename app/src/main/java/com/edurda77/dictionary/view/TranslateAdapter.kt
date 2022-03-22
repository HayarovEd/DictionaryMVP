import TranslateHolder
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.edurda77.dictionary.model.data.datasource.WordTranslate


class TranslateAdapter(
    private val list: List<WordTranslate>,
) :
    RecyclerView.Adapter<TranslateHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TranslateHolder {
        val inflater = LayoutInflater.from(parent.context)
        return TranslateHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: TranslateHolder, position: Int) {
        val wordTranslate: WordTranslate = list[position]
        holder.bind(wordTranslate)
    }

    override fun getItemCount(): Int = list.size
}

