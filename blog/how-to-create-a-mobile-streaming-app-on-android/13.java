class AuthRequestBody(
     @SerializedName("username") val eMail: String,
     @SerializedName("password") val password: String,
@SerializedName("one_time_password") val oneTimePassword: String = "authenticator passcode"
)
interface AuthApi {
        @POST("./auth/jwt/login")
        fun performLogin(@Body body: AuthRequestBody): Single<AuthResponse>
}
private fun auth(eMail: String, password: String) {
     val requestBody = AuthRequestBody(eMail = eMail, password = password)
      compositeDisposable.add(
 (requireActivity().application as GCoreApp).authApi
 .performLogin(requestBody)
 .subscribeOn(Schedulers.computation())
 .observeOn(AndroidSchedulers.mainThread())
   .auth(requireActivity(), requestBody)
                    .subscribe({ authResponse ->
showToast(R.string.logged_success)
     saveAuthData(requestBody, authResponse)
 routeToStreams()
                     }, {
 showToast(R.string.logged_fail)
                     })
     )
}