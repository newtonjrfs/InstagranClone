package com.parse.starter.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;

import com.parse.starter.R;
import com.parse.starter.fragments.HomeFragment;
import com.parse.starter.fragments.UsuariosFragment;

public class TabsAdapter extends FragmentStatePagerAdapter {

    private Context context;
    //private String[] abas = new String[]{"HOME", "USUÁRIOS"};
    private int[] icones = new int[]{R.drawable.ic_action_home,R.drawable.ic_people};
    private int tamanhoIcone ;

    public TabsAdapter(FragmentManager fm, Context c) {
        super(fm);
        this.context = c;
        double escala = this.context.getResources().getDisplayMetrics().density;
        tamanhoIcone = (int) ( escala * 36 );
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        switch (position){

            case 0 :
                fragment = new HomeFragment();
                break;
            case 1:
                fragment = new UsuariosFragment();
                break;

        }
        return  fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        //Recuperar icone com a posicao
        Drawable drawable = ContextCompat.getDrawable(this.context,icones [position]);
        drawable.setBounds(0,0,tamanhoIcone,tamanhoIcone);

        //Permite coloca imagem no texto
        ImageSpan imageSpan = new ImageSpan(drawable);

        //Classe utilizada para retornar char
        SpannableString  spannableString = new SpannableString( " " );
        spannableString.setSpan(imageSpan,0,spannableString.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);




        return spannableString;
    }

    @Override
    public int getCount() {
        return icones.length;
    }
}
