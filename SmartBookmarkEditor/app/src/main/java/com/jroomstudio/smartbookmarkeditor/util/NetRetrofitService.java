package com.jroomstudio.smartbookmarkeditor.util;

import com.jroomstudio.smartbookmarkeditor.data.bookmark.Bookmark;
import com.jroomstudio.smartbookmarkeditor.data.category.Category;
import com.jroomstudio.smartbookmarkeditor.data.member.JsonWebToken;
import com.jroomstudio.smartbookmarkeditor.data.member.Member;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Service Interface
 * - 웹서버와 통신을 위한 API 를 정의하기 위한 인터페이스
 * - POST, DELETE, GET, PUT 등 다양한 Request Method 제공
 **/

public interface NetRetrofitService {

    String SERVER_URL = "http://115.68.221.104";

    // json 으로 데이터 넘기기 - Register
    @POST("member/api/register.php")
    Call<Void> postData(
            @Header("Content-Type") String contentType,
            @Body Member param);

    // Json 으로 넘기고 jwt 콜백 - Login & JWT 발행
    @POST("member/api/login.php")
    Call<JsonWebToken> postTokenCallback(
            @Header("Content-Type") String contentType,
            @Body Member param);

    // 토큰 재발행
    @POST("member/api/login.php")
    Call<JsonWebToken> refreshTokenCallback(
            @Header("Content-Type") String contentType,
            @Body Member param);

    /**
     * Member 관련
     **/

    // Json 으로 넘기고 해당 유저 데이터 콜백
    @POST("member/api/userData.php")
    Call<Member> postDataCallback(
            @Header("Authorization") String auth,
            @Header("Content-Type") String contentType,
            @Body Member param);
    // Json 으로 넘긴 값으로 유저 데이터 업데이트
    @POST("member/api/updateUserData.php")
    Call<Member> updateDataCallback(
            @Header("Authorization") String auth,
            @Header("Content-Type") String contentType,
            @Body Member param);

    /**
     * 카테고리 , 북마크
     **/
    // 카테고리 저장
    @POST("member/api/saveCategory.php")
    Call<Void> saveCategory(
            @Header("Authorization") String auth,
            @Header("Content-Type") String contentType,
            @Header("MemberEmail") String email,
            @Body Category param);

    // 카테고리 리스트 가져오기
    @GET("member/api/getCategories.php")
    Call<List<Category>> getAllCategories(
            @Header("Authorization") String auth,
            @Query("member_email") String email
    );

    // 카테고리 선택
    @GET("member/api/selectedCategory.php")
    Call<Void> selectedCategory(
            @Header("Authorization") String auth,
            @Query("member_email") String email,
            @Query("category_title") String category);

    // 입력된 카테고리를 제거
    @GET("member/api/deleteCategory.php")
    Call<Void> deleteCategory(
            @Header("Authorization") String auth,
            @Query("member_email") String email,
            @Query("category_title") String category);

    // 카테고리 업데이트
    // 카테고리 저장
    @GET("member/api/updateCategory.php")
    Call<Void> updateCategory(
            @Header("Authorization") String auth,
            @Query("member_email") String email,
            @Query("category_id") String id,
            @Query("update_title") String title);

    // 카테고리 포지션 변경
    @POST("member/api/updateCategoryPosition.php")
    Call<Void> updateCategoryPosition(
            @Header("Authorization") String auth,
            @Header("Content-Type") String contentType,
            @Header("MemberEmail") String email,
            @Body List<Category> params);

    // 북마크 포지션 변경
    @POST("member/api/updateBookmarkPosition.php")
    Call<Void> updateBookmarkPosition(
            @Header("Authorization") String auth,
            @Header("Content-Type") String contentType,
            @Header("MemberEmail") String email,
            @Body List<Bookmark> params);

    // 북마크 저장
    @POST("member/api/saveBookmark.php")
    Call<Void> saveBookmark(
            @Header("Authorization") String auth,
            @Header("Content-Type") String contentType,
            @Header("MemberEmail") String email,
            @Body Bookmark param);

    // 북마크 리스트 가져오기
    @GET("member/api/getBookmarks.php")
    Call<List<Bookmark>> getBookmarks(
            @Header("Authorization") String auth,
            @Query("member_email") String email,
            @Query("category_title") String category);

    // Json 으로 넘긴 값으로 북마크 데이터 업데이트 후 콜백
    @GET("member/api/getBookmark.php")
    Call<Bookmark> getBookmark(
            @Header("Authorization") String auth,
            @Query("member_email") String email,
            @Query("category_title") String categoryTitle,
            @Query("bookmark_id") String bookmarkId);

    // 입력된 id의 Bookmark 객체를 찾아서 제거
    @GET("member/api/deleteBookmark.php")
    Call<Void> deleteBookmark(
            @Header("Authorization") String auth,
            @Query("member_email") String email,
            @Query("bookmark_id") String id,
            @Query("category_title") String category);

    // 업데이트 북마크
    @GET("member/api/updateBookmark.php")
    Call<Void> updateBookmark(
            @Header("Authorization") String auth,
            @Query("member_email") String email,
            @Query("update_category") String updateCategory,
            @Query("bookmark_id") String id,
            @Query("bookmark_title") String title,
            @Query("bookmark_url") String url,
            @Query("bookmark_category") String category,
            @Query("bookmark_favicon") String favicon);
}
