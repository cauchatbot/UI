# UI
* DDOKDDOK Chatbot의 UI Repository입니다.
# 
# 실행방법
* Maven을 이용하는 프로젝트이므로, .zip파일을 로컬에 다운받아서 Maven Project에 Import해야합니다.
* Javafx 기반의 UI입니다. javafxapplication을 extends하고있는 Main.java파일을 run하면, UI의 PrimaryStage를 Start합니다.
* TwitchController.java와 YoutubeController.java의 Desktop.getDesktop().edit(new File("AbsolutePath"));으로 구현된 필터링 할 욕설과 채팅 허용 url링크, 입장 안내를 받을 스트리머 각각의 목록을 저장하고있는 .txt파일을 여는 부분에서, "AbsolutePath"부분을 RelativePath로 대체하는 방법을 아직 찾지 못해서, 실행하실 때 Repository에 포함되어있는 keywords.txt, urls.txt, streamers.txt파일의 절대경로를 수정해주셔야합니다.

 
