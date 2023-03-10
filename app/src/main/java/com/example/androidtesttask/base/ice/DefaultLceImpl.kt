package com.example.androidtesttask.base.ice

import android.view.View
import android.widget.TextView
import com.example.androidtesttask.R

/**
 * 具体的策略
 */
class DefaultLceImpl constructor(
    private val loading: View?,
    private val loadErrorView: View?,
    private val badNetworkView: View?,
    private val noContentView: View?
) : ILce {

    override fun startLoading() {
        loadFinished()
        loading?.visibility = View.VISIBLE
    }

    override fun loadFinished() {
        loading?.visibility = View.GONE
        badNetworkView?.visibility = View.GONE
        noContentView?.visibility = View.GONE
        loadErrorView?.visibility = View.GONE
    }

    override fun showLoadErrorView(tip: String) {
        loadFinished()
        val loadErrorText = loadErrorView?.findViewById<TextView>(R.id.loadErrorText)
        loadErrorText?.text = tip
        loadErrorView?.visibility = View.VISIBLE
    }

    override fun showBadNetworkView(listener: View.OnClickListener) {
        loadFinished()
        badNetworkView?.visibility = View.VISIBLE
        badNetworkView?.setOnClickListener(listener)
    }

    override fun showNoContentView(tip: String) {
        loadFinished()
        val noContentText = noContentView?.findViewById<TextView>(R.id.noContentText)
        noContentText?.text = tip
        noContentView?.visibility = View.VISIBLE
    }

}