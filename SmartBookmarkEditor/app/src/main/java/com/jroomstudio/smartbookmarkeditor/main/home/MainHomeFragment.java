package com.jroomstudio.smartbookmarkeditor.main.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jroomstudio.smartbookmarkeditor.Injection;
import com.jroomstudio.smartbookmarkeditor.R;
import com.jroomstudio.smartbookmarkeditor.databinding.MainHomeFragBinding;
import com.jroomstudio.smartbookmarkeditor.itemtouch.ItemTouchEditActivity;
import com.jroomstudio.smartbookmarkeditor.main.MainActivity;

import java.util.ArrayList;


/**
 * 카테고리 / 북마크 리스트를 표시하는 프래그먼트
 **/
public class MainHomeFragment extends Fragment {

    //fab 버튼 -> item touch activity 이동
    private FloatingActionButton fab;

    // 뷰모델
    private MainHomeViewModel mMainHomeViewModel;

    /**
     * 프래그먼트 레이아웃 내부에 데이터 바인딩을 구현
     * 자동으로 생성되는 데이터바인딩 객체
     * -> 해당 객채를 활용하면 find.viewById 없이 뷰 아이템에 접근 가능하다.
     * */
    private MainHomeFragBinding mMainFragBinding;

    // 다이렉트 인스턴스 생성 방지
    public MainHomeFragment() {}

    // 프래그먼트 인스턴스 생성
    public static MainHomeFragment newInstance() { return new MainHomeFragment(); }

    @Override
    public void onResume() {
        super.onResume();
        mMainHomeViewModel.start();
    }

    // 데이터바인딩 -> 뷰 표시
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 현재 프래그먼트의 xml 정보를 액티비티의 viewGroup 에 추가한다.
        mMainFragBinding = MainHomeFragBinding.inflate(inflater,container,false);
        // 레이아웃의 데이터바인딩 view 를 현재 프래그먼트로 설정
        mMainFragBinding.setView(this);
        // 레이아웃의 데이터바인딩 viewModel 을 현재 프래그먼트의 뷰모델로 지정
        mMainFragBinding.setViewmodel(mMainHomeViewModel);
        // 프래그먼트에서 지정한 옵션메뉴를 보여준다. (액티비티보다 프래그먼트의 메뉴가 우선)
        setHasOptionsMenu(true);

        // 북마크, 카테고리 리사이클러뷰 셋팅
        setupRecyclerAdapter();

        // view 에 데이터바인딩 getRoot() 매치하여 반환 (view 반환)
        return mMainFragBinding.getRoot();
    }

    // 액티비티 생성 될 때
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setupFab();

    }

    @Override
    public void onStart() {
        super.onStart();
        fab.setVisibility(View.VISIBLE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        fab.setVisibility(View.GONE);
    }

    // 옵션메뉴
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.bookmark_frag_menu, menu);
    }

    // 옵션메뉴 셀렉터 - 툴바
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_add) {// 아이템 추가버튼 클릭
            mMainHomeViewModel.addNewItem();
        }
        return true;
    }

    /**
     * 메인 액티비티에서 호출
     * 프래그먼트와 뷰모델을 매치시킨다.
     * */
    public void setMainViewModel(MainHomeViewModel viewModel) { mMainHomeViewModel = viewModel; }

    // Floating Action Button 셋팅
    @SuppressLint("ResourceAsColor")
    private void setupFab() {
        fab = (FloatingActionButton) getActivity().findViewById(R.id.fab_setting_items);

        fab.setOnClickListener(v -> {
            Intent intent =
                    new Intent(getContext().getApplicationContext(), ItemTouchEditActivity.class);
            startActivity(intent);
        });

    }

    // 북마크, 카테고리의 리사이클러뷰 어댑터 셋팅
    private void setupRecyclerAdapter(){

        //1. 북마크 어댑터 생성
        // 북마크 리사이클러뷰 어댑터
        BookmarkRecyclerAdapter mBookmarkRecyclerAdapter = new BookmarkRecyclerAdapter(
                new ArrayList<>(0),
                Injection.provideBookmarksRepository(getContext().getApplicationContext()),
                mMainHomeViewModel,
                (MainActivity) getActivity()
        );

        /**
         * https://developer88.tistory.com/119
         * 리사이클러뷰 깜빡임 방지
         **/
        // 깜빡임 방지
        mBookmarkRecyclerAdapter.setHasStableIds(true);

        // 리사이클러뷰 레이아웃 매니져
        mMainFragBinding.rvBookmarks.setLayoutManager(
                new LinearLayoutManager(getContext().getApplicationContext())
        );
        // 리사이클러뷰 어댑터 셋팅
        mMainFragBinding.rvBookmarks.setAdapter(mBookmarkRecyclerAdapter);


        //2. 카테고리 어댑터 생성
        // 카테고리 리사이클러뷰 어댑터
        // 카테고리 리사이클러뷰 어댑터
        CategoriesRecyclerAdapter mCategoriesRecyclerAdapter = new CategoriesRecyclerAdapter(
                new ArrayList<>(0),
                Injection.provideCategoriesRepository(getContext().getApplicationContext()),
                mMainHomeViewModel,
                (MainActivity) getActivity()
        );
        // 깜빡임 방지
        mCategoriesRecyclerAdapter.setHasStableIds(true);
        // 리사이클러뷰 레이아웃 메니저
        mMainFragBinding.rvCategories.setLayoutManager(
                new LinearLayoutManager(getContext().getApplicationContext())
        );
        // 리사이클러뷰 어댑터 셋팅
        mMainFragBinding.rvCategories.setAdapter(mCategoriesRecyclerAdapter);
    }

}
