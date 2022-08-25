import 'package:flutter/material.dart';
import 'package:flutter/src/foundation/key.dart';
import 'package:flutter/src/widgets/framework.dart';
import 'package:flutter_user/features/user/presentation/widget/create_user2_widget.dart';
import 'package:flutter_user/features/user/presentation/widget/delete_user2.dart';
import 'package:flutter_user/features/user/presentation/widget/get_all_user.dart';
import 'package:flutter_user/features/user/presentation/widget/response1_widget.dart';
import 'package:flutter_user/features/user/presentation/widget/response2_widget.dart';
import 'package:flutter_user/features/user/presentation/widget/update_user2_widget.dart';

class HomePage extends StatelessWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text("home page")),
      body: Column(
        children: [
          // Text("home page"),
          Response1(),
          Response2(),
          CreateUser2(),
          UpdateUser2(),
          DeleteUser2(),
          GetAllUser(),
        ],
      ),
    );
  }
}
