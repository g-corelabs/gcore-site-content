interface StreamsApi {
 //...
 @GET("/vp/api/streams/{stream_id}")
 fun getStreamDetailed(
 @Header("Authorization") accessToken: String,
 @Path("stream_id") streamId: Int
 ): Single<StreamDetailedResponse>
 //...
}
private fun getStreamDetailedInfo(streamId: Int) {
 val accessToken = getAccessToken()
 compositeDisposable.add(
 (requireActivity().application as GCoreApp).streamsApi
 .getStreamDetailed("Bearer $accessToken", streamId)
 .subscribeOn(Schedulers.computation())
 .observeOn(AndroidSchedulers.mainThread())
 .subscribe({ streamDetailedInfo ->
 //...
 }, {
 it.printStackTrace()
 })
 )
}