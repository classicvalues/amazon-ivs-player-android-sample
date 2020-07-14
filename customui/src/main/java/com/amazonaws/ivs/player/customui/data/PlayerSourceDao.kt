package com.amazonaws.ivs.player.customui.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.amazonaws.ivs.player.customui.data.entity.SourceDataItem
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerSourceDao {

    // Get source
    @Query("SELECT * FROM source_table")
    fun getAll(): Flow<List<SourceDataItem>>

    // Insert source
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(sourceDataItem: SourceDataItem)

    // Delete source
    @Query("DELETE FROM source_table WHERE url = :url")
    fun delete(url: String)
}
