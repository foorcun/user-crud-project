import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter/src/foundation/key.dart';
import 'package:flutter/src/widgets/framework.dart';
import 'package:flutter_user/features/user/data/data_api.dart';
import 'package:flutter_user/features/user/domain/entity/my_user.dart';
import 'package:flutter_user/features/user/presentation/state_management/controller/my_user_controller.dart';
import 'package:get/get.dart';

class Response2 extends StatelessWidget {
  const Response2({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
        onPressed: () async {
          // DataApi.printTest();
          // DataApi.response2();
          String json = '{"documentId": "user_2"}';
          Get.find<MyUserController>().getUser(MyUser.fromJson(json));
        },
        child: Text("Response2"));
  }
}
