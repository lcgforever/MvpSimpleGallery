package com.chenguangliu.android.mvpsimplegallery.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.chenguangliu.android.mvpsimplegallery.R
import com.chenguangliu.android.mvpsimplegallery.dagger.annotation.ActivityScope
import com.chenguangliu.android.mvpsimplegallery.network.model.Photo
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

@ActivityScope
class MainFragment @Inject constructor() : DaggerFragment(), MainActivityContract.ViewContract {

    @Inject
    lateinit var presenter: MainActivityContract.PresenterContract

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViews()
        presenter.attach(this)
        presenter.onViewReady()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detach()
    }

    private fun setupViews() {
        mainFragmentSwipeRefreshLayout.isRefreshing = true
        mainFragmentSwipeRefreshLayout.setOnRefreshListener {
            mainFragmentSwipeRefreshLayout.isRefreshing = true
            showPhotoList()
            presenter.onRefresh()
        }
        val context = requireContext()
        mainFragmentRecyclerView.layoutManager = GridLayoutManager(context, 2)
        mainFragmentRecyclerView.adapter = MainFragmentPhotoAdapter(context, emptyList())
    }

    override fun updatePhotoList(photoList: List<Photo>) {
        mainFragmentSwipeRefreshLayout.isRefreshing = false
        showPhotoList()
        (mainFragmentRecyclerView.adapter as? MainFragmentPhotoAdapter)?.updatePhotoList(photoList)
    }

    override fun showLoadingError(error: Throwable) {
        view?.let {
            Snackbar
                .make(it, R.string.load_photos_error_snack_message, Snackbar.LENGTH_LONG)
                .show()
        }
        mainFragmentSwipeRefreshLayout.isRefreshing = false
        showLoadErrorText()
    }

    private fun showPhotoList() {
        mainFragmentLoadErrorTextView.visibility = View.GONE
        mainFragmentRecyclerView.visibility = View.VISIBLE
    }

    private fun showLoadErrorText() {
        mainFragmentRecyclerView.visibility = View.GONE
        mainFragmentLoadErrorTextView.visibility = View.VISIBLE
    }
}
