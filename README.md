# Android_PermissionCheck_Java
안드로이드 권한 요청 클래스입니다.(java)


사용방법
permission처리를 할 activity 상속 클래스에서
PermissionCheck 클래스 선언.

check함수(파라미터로 permission 리스트를 전달) 사용함으로써 유저에게 권한요청 실행

예)
List<String> myPermission = Arrays.asList(
        new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE});

PermissionCheck permissionCheck = new PermissionCheck(this);
permissionCheck.check(myPermission);
