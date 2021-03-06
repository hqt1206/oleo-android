package com.framgia.oleo.data.source

import com.framgia.oleo.data.source.model.FriendRequest
import com.framgia.oleo.data.source.model.Place
import com.framgia.oleo.data.source.model.User
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.ValueEventListener

interface UserDataSource {
    interface Local {
        fun getUser(): User?

        fun insertUser(vararg users: User)

        fun deleteUser()

        fun updateUser(vararg users: User)
    }

    interface Remote {
        fun pushUserLocation(idUser: String, place: Place)

        fun getUserByPhoneNumber(phoneNumber: String, valueEventListener: ValueEventListener)

        fun registerUser(
            user: User,
            onCompleteListener: OnCompleteListener<Void>,
            onFailureListener: OnFailureListener
        )

        fun getUsers(valueEventListener: ValueEventListener)

        fun getFriendLocation(id: String, childEventListener: ChildEventListener)

        fun addFriendRequest(
            reciveId: String,
            user: User,
            message: String,
            onSuccessListener: OnSuccessListener<Void>,
            onFailureListener: OnFailureListener
        )

        fun getUserById(userId: String, singleValueEventListener: ValueEventListener)

        fun getFriendRequests(userId: String, valueEventListener: ValueEventListener)

        fun confirmFriendRequest(
            user: User,
            friendRequest: FriendRequest,
            onSuccessListener: OnSuccessListener<Void>,
            onFailureListener: OnFailureListener
        )

        fun deleteFriendRequest(
            user: User,
            friendRequest: FriendRequest,
            onSuccessListener: OnSuccessListener<Void>,
            onFailureListener: OnFailureListener
        )

        fun changeStatusFriendRequest(
            user: User,
            friendRequest: FriendRequest,
            status: Int,
            onSuccessListener: OnSuccessListener<Void>,
            onFailureListener: OnFailureListener
        )

        fun addFriend(user: User, friendRequest: FriendRequest)
    }
}
