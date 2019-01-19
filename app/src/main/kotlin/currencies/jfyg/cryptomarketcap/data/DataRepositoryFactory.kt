package currencies.jfyg.cryptomarketcap.data

class DataRepositoryFactory constructor(
        private val localDataSource: DataRepository,
        private val remoteDataSource: DataRepository) {

    fun retrieveRemoteSource(): DataRepository =
            remoteDataSource

    fun retrieveLocalSource(): DataRepository =
            localDataSource

}