package lt.autoservis.u5.services;

//@Service
//@Slf4j
//@RequiredArgsConstructor
//public class vartotojasService {
//    private final VartotojasRepository vartotojasRepository;
//    private final PasswordEncoder passwordEncoder;

//    public boolean createUser(Vartotojas user) {
//        String username = user.getUsername();
//        if (vartotojasRepository.findByUsername(username) != null) return false;
//        user.setEnabled(true);
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.roles().get(Role.vartojuRoles);
//        log.info("Saving new User with userName: {}", username);
//        vartotojasRepository.save(user);
//        return true;
//    }
//
//    public List<Vartotojas> list() {
//        return vartotojasRepository.findAll();
//    }
//
//    public void banUser(Long id) {
//        Vartotojas user = vartotojasRepository.findById(id).orElse(null);
//        if (user != null) {
//            if (user.isEnabled()) {
//                user.setEnabled(false);
//                log.info("Ban user with id = {}; userName: {}", user.getId(), user.getUsername());
//            } else {
//                user.setEnabled(true);
//                log.info("Unban user with id = {}; userName: {}", user.getId(), user.getUsername());
//            }
//        }
//        vartotojasRepository.save(user);
//    }
//
////    public void changeUserRoles(Vartotojas user, Map<String, String> form) {
////        Set<String> roles = Arrays.stream(Role.privilegijuRoles())
////                .map(Role::name)
////                .collect(Collectors.toSet());
////        user.roles().clear();
////        for (String key : form.keySet()) {
////            if (roles.contains(key)) {
////                user.getRoles().add(Role.valueOf(key));
////            }
////        }
////        vartotojasRepository.save(user);
////    }
////
////    public Vartotojas getUserByPrincipal(Principal principal) {
////        if (principal == null) return new Vartotojas();
////        return vartotojasRepository.findByUsername(principal.getName());
////    }
//}
