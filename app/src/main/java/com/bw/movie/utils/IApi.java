package com.bw.movie.utils;


import com.bw.movie.bean.CxdyplBean;
import com.bw.movie.bean.CxgzdyBean;
import com.bw.movie.bean.CxgzyyBean;
import com.bw.movie.bean.CxyhBean;
import com.bw.movie.bean.CxyyplBean;
import com.bw.movie.bean.DdxqBean;
import com.bw.movie.bean.DypqBean;
import com.bw.movie.bean.DyssBean;
import com.bw.movie.bean.DyypBean;
import com.bw.movie.bean.EmailBean;
import com.bw.movie.bean.EmailMessageBean;
import com.bw.movie.bean.FkBean;
import com.bw.movie.bean.GpjlBean;
import com.bw.movie.bean.GzdyBean;
import com.bw.movie.bean.GzyyBean;
import com.bw.movie.bean.HotBean;
import com.bw.movie.bean.IdTimeYingYuanBean;
import com.bw.movie.bean.JgcxBean;
import com.bw.movie.bean.LoginBean;
import com.bw.movie.bean.PingLunBean;
import com.bw.movie.bean.QxgzdyBean;
import com.bw.movie.bean.QxgzyyBean;
import com.bw.movie.bean.QyBean;
import com.bw.movie.bean.QycxBean;
import com.bw.movie.bean.RegionBean;
import com.bw.movie.bean.RegisterBean;
import com.bw.movie.bean.ShowBean;
import com.bw.movie.bean.ShowingBean;
import com.bw.movie.bean.TimeBean;
import com.bw.movie.bean.TjyyBean;
import com.bw.movie.bean.TxBean;
import com.bw.movie.bean.WxLogBean;
import com.bw.movie.bean.XbannerBean;
import com.bw.movie.bean.XdBean;
import com.bw.movie.bean.XiangqingBean;
import com.bw.movie.bean.XuanZuoBean;
import com.bw.movie.bean.YyplBean;
import com.bw.movie.bean.YypqBean;
import com.bw.movie.bean.YyxiangqingBean;
import com.bw.movie.bean.ZfBean;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Retrofit默认只使用这一个IApi
 * <p>
 * <p>
 * 使用规范：
 * 一个http请求对应该接口中一个方法
 */
public interface IApi {

    @FormUrlEncoded
    @POST("user/v2/login")
    Observable<LoginBean> getLogin(@Field("email")String email,@Field("pwd")String pwd);
    @FormUrlEncoded
    @POST("user/v2/register")
    Observable<RegisterBean> getRegister(@Field("nickName")String nickName,@Field("pwd")String pwd,@Field("email")String email,@Field("code")String code);
    @FormUrlEncoded
    @POST("user/v2/sendOutEmailCode")
    Observable<EmailBean> getEmail(@Field("email")String email);

    @GET("movie/v2/findReleaseMovieList")
    Observable<ShowingBean> getShowing(@Query("page")String page, @Query("count")String count);



    @GET("movie/v2/findComingSoonMovieList")
    Observable<ShowBean> getShow(@Query("page")String page, @Query("count")String count, @QueryMap()Map<String,String> map);

    @GET("movie/v2/findHotMovieList")
    Observable<HotBean> getHot(@Query("page")String page, @Query("count")String count);

    @GET("tool/v2/banner")
    Observable<XbannerBean> getXbanner();

    //影院地址
    @GET("cinema/v2/findCinemaByRegion")
    Observable<RegionBean>getRegion(@Query("regionId")String regionId);
    //推荐影院
    @GET("cinema/v1/findRecommendCinemas")
    Observable<TjyyBean>getTjyy(@Query("page")String page, @Query("count")String count);
    //详情
    @GET("movie/v2/findMoviesDetail")
    Observable<XiangqingBean> getXiangqing(@HeaderMap Map<String,Object> map,@Query("movieId")String movieId);
    //评论
    @GET("movie/v2/findAllMovieComment")
    Observable<PingLunBean>getPingLun(@Query("movieId") String movieId,@Query("page")String page,@Query("count")String count);



    //根据电影id，时间 查询播放影院信息
    @GET("movie/v2/findCinemasInfoByDate")
    Observable<IdTimeYingYuanBean>getIdTimeYingYuan(@Query("movieId") String movieId,@Query("date") String date,@Query("page") String page,@Query("count") String count);
    //根据电影id,区域id 查询播放影院信息
    @GET("movie/v2/findCinemasInfoByRegion")
    Observable<QycxBean>getQycx(@Query("movieId") String movieId, @Query("regionId") String regionId, @Query("page") String page, @Query("count") String count);
   //根据电影价格查询播放影院信息
   @GET("movie/v2/findCinemasInfoByPrice")
   Observable<JgcxBean>getJgcx(@Query("movieId") String movieId, @Query("page") String page, @Query("count") String count);
    //时间
    @GET("tool/v2/findDateList")
    Observable<TimeBean>gettime();
    //查询区域列表
    @GET("tool/v2/findRegionList")
    Observable<QyBean>getQy();




    //选座
    @GET("movie/v2/findSeatInfo")
    Observable<XuanZuoBean>getXuanZuo(@Query("hallId")String hallId);
    //根据电影ID和影院ID查询电影排期列表
    @GET("movie/v2/findMovieSchedule")
    Observable<DypqBean>getDypq(@Query("movieId")String movieId, @Query("cinemaId")String cinemaId);
    //下单
    @FormUrlEncoded
    @POST("movie/v2/verify/buyMovieTickets")
    Observable<XdBean> getXd(@Header("userId") String userId, @Header("sessionId")String sessionId, @Field("scheduleId")String scheduleId, @Field("seat")String seat, @Field("sign")String sign);

    //支付
    @FormUrlEncoded
    @POST("movie/v2/verify/pay")
    Observable<ZfBean> getZf(@Header("userId") String userId, @Header("sessionId")String sessionId, @Field("payType")String payType, @Field("orderId")String orderId);
    //查询影院信息明细
    @GET("cinema/v1/findCinemaInfo")
    Observable<YyxiangqingBean>getYyxiangqing(@Query("cinemaId")String cinemaId);
    //查询影院用户评论列表
    @GET("cinema/v1/findAllCinemaComment")
    Observable<YyplBean>getYypl(@Header("userId") String userId, @Header("sessionId")String sessionId, @Query("cinemaId") String cinemaId, @Query("page") String page, @Query("count") String count);
    //查询影院下的电影排期
    @GET("cinema/v2/findCinemaScheduleList")
    Observable<YypqBean>getYypq(@Query("cinemaId")String cinemaId,@Query("page")String page,@Query("count")String count);
    //根据关键字查询电影信息
    @GET("movie/v2/findMovieByKeyword")
    Observable<DyssBean>getDyss(@Query("keyword")String keyword,@Query("page")String page,@Query("count")String count);
    //购票记录
    @GET("user/v2/verify/findUserBuyTicketRecord")
    Observable<GpjlBean>getGpjl(@Header("userId") String userId, @Header("sessionId")String sessionId,@Query("page")String page,@Query("count")String count,@Query("status") String status);
    //查看订单详情
    @GET("user/v2/verify/findBuyTicketRecordByOrderId")
    Observable<DdxqBean>getDdxq(@Header("userId") String userId, @Header("sessionId")String sessionId, @Query("orderId")String orderId);
    //添加用户对影片的评论
    @FormUrlEncoded
    @POST("movie/v1/verify/movieComment")
    Observable<DyypBean>getDyyp(@Header("userId") String userId, @Header("sessionId")String sessionId,@Field("movieId")String movieId,@Field("commentContent")String commentContent,@Field("score")String score);
    //查询我对电影的评论列表
    @GET("user/v2/verify/findMyMovieCommentList")
    Observable<CxdyplBean>getCxdypl(@Header("userId") String userId, @Header("sessionId")String sessionId, @Query("page") String page, @Query("count") String count);
    //查询我对影院评论列表
    @GET("user/v2/verify/findMyCinemaCommentList")
    Observable<CxyyplBean>getCxyypl(@Header("userId") String userId, @Header("sessionId")String sessionId, @Query("page") String page, @Query("count") String count);
    //查询用户关注电影列表
    @GET("user/v2/verify/findUserFollowMovieList")
    Observable<CxgzdyBean>getCxgzdy(@Header("userId") String userId, @Header("sessionId")String sessionId, @Query("page") String page, @Query("count") String count);
    //查询用户关注影院列表
    @GET("user/v2/verify/findUserFollowCinemaList")
    Observable<CxgzyyBean>getCxgzyy(@Header("userId") String userId, @Header("sessionId")String sessionId, @Query("page") String page, @Query("count") String count);
    //关注电影
    @GET("movie/v1/verify/followMovie")
    Observable<GzdyBean>getGzdy(@Header("userId") String userId, @Header("sessionId")String sessionId, @Query("movieId") String movieId);
    //关注影院
    @GET("cinema/v1/verify/followCinema")
    Observable<GzyyBean>getGzyy(@Header("userId") String userId, @Header("sessionId")String sessionId, @Query("movieId") String cinemaId);
    //取消关注电影
    @GET("movie/v1/verify/cancelFollowMovie")
    Observable<QxgzdyBean>getQxgzdy(@Header("userId") String userId, @Header("sessionId")String sessionId, @Query("movieId") String movieId);
    //取消关注影院
    @GET("cinema/v1/verify/cancelFollowCinema")
    Observable<QxgzyyBean>getQxgzyy(@Header("userId") String userId, @Header("sessionId")String sessionId, @Query("movieId") String cinemaId);
    //反馈
    @FormUrlEncoded
    @POST("tool/v1/verify/recordFeedBack")
    Observable<FkBean>getFk(@Header("userId") String userId, @Header("sessionId")String sessionId, @Field("content")String content);
    //微信登陆
    @FormUrlEncoded
    @POST("user/v1/weChatBindingLogin")
    Observable<WxLogBean>getWxlog(@Field("code")String code);
    //根据用户ID查询用户信息
    @GET("user/v1/verify/getUserInfoByUserId")
    Observable<CxyhBean>getCxyh(@Header("userId") String userId, @Header("sessionId")String sessionId);
    //上传用户头像
    @Multipart
    @POST("user/v1/verify/uploadHeadPic")
    Observable<TxBean>getTx(@Header("userId") String userId, @Header("sessionId")String sessionId,@Part MultipartBody.Part MultiparFile);
    //查询系统消息列表
    @GET("tool/v1/verify/findAllSysMsgList")
    Observable<EmailMessageBean> EmailMessage(@Header("userId") String userId, @Header("sessionId") String sessionId,
                                              @Query("page")String page, @Query("count")String count);
}
