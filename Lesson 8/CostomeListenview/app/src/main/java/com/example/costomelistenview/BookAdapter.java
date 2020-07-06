package com.example.costomelistenview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.Inflater;

import javax.sql.StatementEvent;

public class BookAdapter extends BaseAdapter
{

    Context activity;
    LayoutInflater inflater=null;
    ArrayList<HashMap<String,Object>> acces =new ArrayList<>();


    public BookAdapter(Context context, ArrayList<HashMap<String, Object>> access)
    {
        activity=context;
        acces=access;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        if(acces.size()<=0)
        {
            return 0;
        }
        else
        {
            return acces.size();
        }

    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    public static class ViewHolder
    {
        TextView name ;
        ImageView image;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vi=view;
        ViewHolder holder;
        if(view==null)
        {
           vi= inflater.inflate(R.layout.list_item,null);

           holder=new ViewHolder();

           holder.name=(TextView)vi.findViewById(R.id.textView);
           holder.image=(ImageView)vi.findViewById(R.id.imageView);
           String kitabIsimi= acces.get(i).get("Name").toString();
           String resimYolu=acces.get(i).get("image").toString();

           holder.name.setText(kitabIsimi);
           Picasso.get().load(resimYolu).into(holder.image);

        }
        return vi;
    }
}
