import 'package:flutter_user/features/user/data/data_api.dart';
import 'package:flutter_user/features/user/domain/entity/my_user.dart';
import 'package:get/get.dart';

class MyUserController extends GetxController {
  final userlar = <MyUser>[].obs;

  @override
  void onInit() {
    // TODO: implement onInit
    super.onInit();

    // fetchCityler();
  }

  Future<MyUser> getUser(MyUser myUser) async {
    return DataApi.response1(myUser);
  }

  Future<void> createUser(MyUser myUser) async {
    DataApi.createUser(myUser);
  }

  Future<void> updateUser(MyUser myUser) async {
    DataApi.updateUser(myUser);
  }

  Future<void> deleteUser(MyUser myUser) async {
    DataApi.deleteUser(myUser);
  }

  Future<List<MyUser>> getAllUser() async {
    var v = await DataApi.getAllUser();

    print(userlar.length);
    // for (var fff in v) {
    //   userlar.value.add(fff);
    // }
    userlar.assignAll(v);
    print(userlar.length);

    return userlar;
  }
}
