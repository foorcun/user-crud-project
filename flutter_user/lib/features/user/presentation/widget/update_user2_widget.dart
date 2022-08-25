import 'package:flutter/material.dart';
import 'package:flutter/src/foundation/key.dart';
import 'package:flutter/src/widgets/framework.dart';
import 'package:flutter_user/features/user/data/data_api.dart';
import 'package:flutter_user/features/user/domain/entity/my_user.dart';

class UpdateUser2 extends StatelessWidget {
  const UpdateUser2({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return ElevatedButton(
        onPressed: () async {
          // DataApi.printTest();

          String json =
              '{"documentId": "user_2","name": "name2-updated","profession": "prof2-updated"}';

          MyUser myUser = MyUser.fromJson(json);

          DataApi.updateUser(myUser);
        },
        child: Text("Update user2"));
  }
}
