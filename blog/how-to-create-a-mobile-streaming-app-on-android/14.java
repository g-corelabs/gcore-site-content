interface StreamsApi {
 /**
 * @param page integer; Query parameter. Use it to list the paginated content
 * @param with_broadcasts integer; Query parameter.
 * Set to 1 to get details of the broadcasts associated with the stream
 */
 @GET("./vp/api/streams")
 fun getStreams(
 @Header("Authorization") accessToken: String,
 @Query("page") page: Int,
 @Query("with_broadcasts") withBroadcasts: Int = 1
 ): Single<List<StreamItemResponse>>
 //...
}
private fun loadStreamItems(page: Int = 1) {
 val accessToken = getAccessToken()
 var currentPage = page
 if (currentPage == 1) {
 streamItems.clear()
 }
 compositeDisposable.add(
 (requireActivity().application as GCoreApp).streamsApi
 .getStreams("Bearer $accessToken", page = currentPage)
 .subscribeOn(Schedulers.computation())
 .observeOn(AndroidSchedulers.mainThread())
 .subscribe({
 if (it.isNotEmpty()) {
 it.forEach { streamItemResponse ->
 streamItems.add(StreamItemModel.getInstance(streamItemResponse))
 }
 loadStreamItems(page = ++currentPage)
 } else {
 updateDataInAdapter()
 }
 }, {
 it.printStackTrace()
 })
 )
}