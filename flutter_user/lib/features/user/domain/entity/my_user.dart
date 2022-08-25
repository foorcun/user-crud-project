import 'dart:convert';

class MyUser {
  String? documentId;
  String? name;
  String? profession;

  MyUser.empty();

  MyUser({
    this.documentId,
    this.name,
    this.profession,
  });

  Map<String, dynamic> toMap() {
    return {
      'documentId': documentId,
      'name': name,
      'profession': profession,
    };
  }

  factory MyUser.fromMap(Map<String, dynamic> map) {
    return MyUser(
      documentId: map['documentId'],
      name: map['name'],
      profession: map['profession'],
    );
  }

  String toJson() => json.encode(toMap());

  factory MyUser.fromJson(String source) {
    return MyUser.fromMap(json.decode(source));
  }
}
