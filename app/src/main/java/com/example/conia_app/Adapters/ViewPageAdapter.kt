package com.example.conia_app.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.conia_app.R

class ViewPageAdapter(private val context: Context) : PagerAdapter() {

    private var layoutInflater: LayoutInflater?= null
    private val images = arrayOf(R.drawable.conia1, R.drawable.conia2, R.drawable.conia3, R.drawable.conia4)

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = layoutInflater!!.inflate(R.layout.template_imagenes_conia, null)
        val image = v.findViewById<View>(R.id.lista_imagenesConia) as ImageView
        image.setImageResource(images[position])

        val vp = container as ViewPager
        vp.addView(v, 0)
        return v
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val vp = container as ViewPager
        val v = `object` as View
        vp.removeView(v)
    }

    operator fun invoke(context: Context?): Context? {

        return context

    }
}