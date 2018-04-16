package cr.ac.unadeca.prcalcu.subclases;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import cr.ac.unadeca.prcalcu.R;

/**
 * Created by Freddy on 4/8/2018.
 */

public class TodoViewHolder extends RecyclerView.ViewHolder {

    public HtmlTextView html;
    public ImageView borrar;



    public TodoViewHolder(View itemView) {
        super(itemView);

        html=itemView.findViewById(R.id.html_text);
        borrar=itemView.findViewById(R.id.delete);
    }
}

//FT