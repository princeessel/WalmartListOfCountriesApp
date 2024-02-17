import com.example.walmartlistofcountriesapp.data.model.Status

data class Resource<out T>(
    val status: Status,
    val data: T?,
    val message:String?
){
    companion object{

        fun <T> success(data:T?): Resource<T>{
            return Resource(Status.SUCCESS, data, null)
        }

        fun <T> error(msg:String? = null, data:T? = null): Resource<T>{
            return Resource(Status.ERROR, data, msg)
        }

        fun <T> loading(data:T? = null): Resource<T>{
            return Resource(Status.LOADING, data, null)
        }

    }
}
