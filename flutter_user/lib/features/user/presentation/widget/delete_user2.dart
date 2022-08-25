import 'package:flutter/material.dart';
import 'package:flutter/src/foundation/key.dart';
import 'package:flutter/src/widgets/framework.dart';
import 'package:flutter_user/features/user/data/data_api.dart';
import 'package:flutter_user/features/user/domain/entity/my_user.dart';
import 'package:flutter_user/features/user/presentation/state_management/controller/my_user_controller.dart';
import 'package:get/get.dart';

class DeleteUser2 extends StatelessWidget {
  const DeleteUser2({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
        onPressed: () async {
          // DataApi.printTest();

          String json =
              '{"documentId": "user_2","name": "name2","profession": "prof2"}';

          MyUser myUser = MyUser.fromJson(json);
          // DataApi.deleteUser(myUser);
          Get.find<MyUserController>().deleteUser(MyUser.fromJson(json));
        },
        child: Text("Delete user2"));
  }
}
