# LeapintheDeep
Book Writing App

Powered by: Spring Boot, Angular, JUnit5, AsserJ, MySQL and more...



# Project Specifications

Team of 2 - specifications
Team members: Alexandru Mitrofan, Diana-Gabriela Neguriță

General description:

This application aims to help people to express their imagination in words and sharing their 
creativity to the world, but also to develop their knowledge.

Registration (for both Reader and Writer):
The user needs to first register into the application by selecting one of the 2 roles: READER
or WRITER. Both roles require a unique username, a password and the basic information like full 
name, email and/or phone number.

Reader: (primary)
After the reader logs in, he can:
• read books,
• add book to favorite – after he reads it 
• add book to wishlist – before he reads it
• rate a book – after he reads it
• comment on a book – after he reads it (need approval of admin for publishing)

Writer: (primary)
After the writer logs in, he can:
• write a new book – a book should contain name, author, at least 15 pages and 2 chapters,
• edit a draft,
• publish a book (need approval of admin for publishing) – the publishing time will be posted 
(day.month.year),
• same attributions as READER

Admin: (secondary)
The app is configured by one or more admins. They are responsible for creating the
accounts both for READER and WRITER. They are also responsible for checking first the content 
that the READER (comments) or WRITER (books, comments) are being published.
• If the account that is created already exists, the system notifies the admin and cancel,
• If the books/comments contain expressions that are not adequate to be published:
o The comment will be immediately not published and removed from history;
o The book will go back to drafts.
• If the book contains similar content with another book that has already been published, the 
book will not be published and will go back to drafts



# Spring Adnotatii

@SpringBootApplication

	Creata pentru clasa in care se creeaza proiectul. Ea trebuie pastrata in pachetul original. Tot ce face e scaneaza dupa sub pachete.

@RestController
Este folosita la nivel de clasa si marcheaza clasa ca fiind un “controller”, unde fiecare metoda returneaza un obiect intr-un domeniu (exemplu afiseaza intr-o pagina web) in loc de a afisa in consola.
	Permite aplicarea operatiilor get, post, put si delete mapping(*) (@GetMapping, @PostMapping, @PutMapping, @DeleteMapping).

@RequestMapping
	Folosita la nivel de clasa sau metoda. Folosita pentru operatiile unei pagini web (cele de sus -> *), in URL-uri diferite (se specific path-ul - asta la nivel de clasa; la nivel de metoda – se specifica care operatie se face -> *).


@GetMapping
	
	Are rol de a afisa intr-o pagina web informatia oferita de un serviciu.

@PostMapping

	Are rol de a salva intr-o pagina web o noua informatie oferita de un serviciu.


@PutMapping
	
	Are rol de a actualiza intr-o pagina web o informatie oferita de o functie (dupa un anumit criteriu cum ar fi id).


@DeleteMapping
	Are rol de a sterge dintr-o pagina web informatia oferita de o functie (dupa un anumit criteriu cum ar fi id).

@Autowired
	
Folosita la field-uri, settere si constructori. Are rol de “injectare de dependente” pe cale implicita. Cand o pui la un field si treci valoarea field-urilor utilizand numele proprietatii, field-urile sunt asignate automat cu acele valori.
@Component (mai specific @Service)

Folosita la clase, pentru a marca faptul ca acea clasa executa un tip de operatie/serviciu astfel incat Spring sa stie pentru a face legaturile necesare intre field-uri, settere si constructori, etc. .

@Entity

Specifica faptul ca acea clasa trebuie mapata intr-un table de baza de date.

@Table

Specifica numele tabelului din acel database care va fi folosit pentru a fi mapat.

@Id
	Specifica care este cheia primara in acel table (se pune inaintea unui atribut al clasei)

@SequenceGenerator

	Se poate controla cum sa fie mapat tabelul sau secventa bazei de date. Poate fi folosita pe clasa entitate sau la campul cheii primare.

@GeneratedValue
	
	Specifica generarea strategiei pentru valorile cheii primare.


@Repository

	Folosita la clase, pentru a da acces direct acesteia la baza de date.	


@Configuration

	Folosita pentru clase, pentru a defini “beans”.

@Bean

	La nivel de metoda. Folosita pentru a instantia metode si configure dependente.

@Transient
	
	Atributul nu are nevoie sa fie o coloana in baza de date.

@RequestBody

	Indica faptul ca un parametru al metodei rebuie sa fie legat de valoarea solicitarii corpului a paginii web.

@PathVariable

	Folosita pentru solicitari ale argumentelor unei metode, mai exact declara un parametru pentru schimbari dinamice intr-un URL, unde anumite valori din URL sunt luate ca si parametru.

@RequestParam

	Folosita pentru solicitari ale argumentelor unei metode, mai exact pentru a lega parametrii solicitati de un parametru dintr-o metoda aflata in controller. 

@Transcational
	
The @Transactional is simply a metadata that can be consumed by some runtime infrastructure. This infrastructure uses the metadata to configure the appropriate beans with transactional behaviour.

	Plasata inainte de o interfata, o metoda dintr-o interfata, o definitie a unei clase sau o metoda publica dintr-o clasa. Folosita pentru a configura bean-urile corespunzătoare cu comportamentul tranzacțional.

@Query

	Interogare a unei metode.

@Column
	
	Folosita pentru adaugarea numelui coloeanei intr-un tabel.
  
@OneToOne

  Specifica o relatie unu-la-unu.
  
@OneToMany

  Specifica o relatie unul-la-mai multe.
  
@ManyToOne

  Specifica o relatie mai multe-la-unul.
  
@NotBlank

  Verifica o secventa de caractere sa nu fie nula din punct de vedere al lungimii sale.

@JoinColumn

	Folosita pentru a indica ca o entitate este posesoarea unei relatii si ca tabelul corespunzator are o cheie straina care refera la tabelul non-posesor. 
 
@NoArgsConstructor, @AllArgsConstrcutor, @Getter, @Setter, @ToString, @EqualsAndHashCode
	
	Auto-genereaza constructor fara argumente, cu toate argumentele, functii de get, functii de set si functia de afisare si functia equals.



# Informatii Pachete:

User = pachetul in care se afla toate clasele aplicatiei
Controller = pachetul in care se afla toate operatiile de maping
Service = pachetul in care se face business logic-ul unei aplicatii
Repository = pachetul in care se acceseaza baza de data -> acestea sunt interfate
