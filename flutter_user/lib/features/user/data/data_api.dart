import 'dart:convert';

import 'package:flutter_user/features/user/domain/entity/my_user.dart';
import 'package:http/http.dart' as http;

class DataApi {
  static var httplocalhost = 'http://localhost:8080';

  static printTest() {
    print("deneme printi");
  }

  static Future<void> response1() async {
    Uri uri = Uri.parse("$httplocalhost/api/get?documentId=user_1");

    http.Response response = await http.get(uri);
    print("gelen user1 : ");
    print(response.body);
    // return response;
  }

  static Future<void> response2() async {
    Uri uri = Uri.parse("$httplocalhost/api/get?documentId=user_2");

    http.Response response = await http.get(uri);
    print("gelen user2 : ");
    print(response.body);
    // return response;}
  }

  static Future<void> createUser(MyUser myUser) async {
    Uri uri = Uri.parse("$httplocalhost/api/create");

    // Map<String, dynamic> postData = {
    //   "documentId": "user_2",
    //   // "name": "Programming knowledge",
    //   "profession": "youtuber"
    // };
    // String body = jsonEncode(postData);

    String body = myUser.toJson();

    var response = await http.post(
      uri,
      body: body,
      headers: {
        "Content-Type": "application/json",
      },
    );

    print("createUser response");
    print(response.body);
  }

  static Future<void> updateUser(MyUser myUser) async {
    Uri uri = Uri.parse("$httplocalhost/api/update");

    // Map<String, dynamic> postData = {
    //   "documentId": "user_2", // bir bilgiyi eksik veririsek put kodu calismaz
    //   "name": "Programming knowledge",
    //   "profession": "youtuber + yeni data"
    // };
    // final body = jsonEncode(postData);

    String body = myUser.toJson();

    var response = await http.put(
      uri,
      body: body,
      headers: {
        "Content-Type": "application/json",
      },
    );

    print("updateUser response");
    print(response.body);
  }

  static Future<void> deleteUser(MyUser myUser) async {
    // Uri uri = Uri.parse("$httplocalhost/delete?documentId=user_2");
    Uri uri =
        Uri.parse("$httplocalhost/api/delete?documentId=${myUser.documentId!}");

    // Map<String, dynamic> postData = {
    //   "documentId": "user_2",
    // };
    // final body = jsonEncode(postData);

    var response = await http.put(
      uri,
      // body: body,
      headers: {
        "Content-Type": "application/json",
      },
    );

    print("deleteUser response");
    print(response.body);
  }
}
