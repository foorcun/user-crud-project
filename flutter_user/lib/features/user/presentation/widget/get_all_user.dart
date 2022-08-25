import 'package:flutter/material.dart';
import 'package:flutter/src/foundation/key.dart';
import 'package:flutter/src/widgets/framework.dart';
import 'package:flutter_user/features/user/domain/entity/my_user.dart';
import 'package:flutter_user/features/user/presentation/state_management/controller/my_user_controller.dart';
import 'package:get/get.dart';

class GetAllUser extends StatelessWidget {
  const GetAllUser({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    print(Get.find<MyUserController>().userlar.length.toString());
    return Column(
      children: [
        ElevatedButton(
            onPressed: () async {
              // DataApi.printTest();
              // DataApi.response1();
              String json = '{"documentId": "user_1"}';
              Get.find<MyUserController>().getAllUser();
            },
            child: Text("Get all user")),
        SizedBox(
          height: 400,
          child: Obx(
            () => ListView.builder(
                // shrinkWrap: true,
                itemCount: Get.find<MyUserController>().userlar.length,
                itemBuilder: (BuildContext context, int index) {
                  print("index " + index.toString());
                  return ListTile(
                    title: Text(Get.find<MyUserController>()
                        .userlar[index]
                        .documentId!),
                  );
                }),
          ),
        ),
      ],
    );
  }
}
