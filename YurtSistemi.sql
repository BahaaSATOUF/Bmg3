PGDMP     4    '            	    y            vvv    14.0    14.0     %           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            &           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            '           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            (           1262    17815    vvv    DATABASE     g   CREATE DATABASE vvv WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'English_United States.1256';
    DROP DATABASE vvv;
                postgres    false            �            1259    17816    calisan    TABLE     �   CREATE TABLE public.calisan (
    tc character varying(11) NOT NULL,
    isim character varying(20),
    dugum_tarihi date,
    telefon_no character varying(11),
    adres character varying(11),
    maas integer,
    maas_alma_tarihi date
);
    DROP TABLE public.calisan;
       public         heap    postgres    false            �            1259    17819    etkinlik    TABLE     �   CREATE TABLE public.etkinlik (
    etkinlik_id integer NOT NULL,
    sunan_hoca character varying(20) NOT NULL,
    etkinlik_turu character varying(20) NOT NULL,
    aciklama text
);
    DROP TABLE public.etkinlik;
       public         heap    postgres    false            �            1259    17824    kat    TABLE     W   CREATE TABLE public.kat (
    kat_numarasi integer NOT NULL,
    oda_sayisi integer
);
    DROP TABLE public.kat;
       public         heap    postgres    false            �            1259    17827    kitablik    TABLE     �   CREATE TABLE public.kitablik (
    kitap_id integer NOT NULL,
    kitap_adi character varying(20) NOT NULL,
    yazar character varying(20) NOT NULL
);
    DROP TABLE public.kitablik;
       public         heap    postgres    false            �            1259    17830    kural    TABLE     k   CREATE TABLE public.kural (
    kural_id integer NOT NULL,
    aciklama character varying(100) NOT NULL
);
    DROP TABLE public.kural;
       public         heap    postgres    false            �            1259    17833    muhasebe_personeli    TABLE     F   CREATE TABLE public.muhasebe_personeli (
)
INHERITS (public.calisan);
 &   DROP TABLE public.muhasebe_personeli;
       public         heap    postgres    false    209            �            1259    17836    oda    TABLE     s   CREATE TABLE public.oda (
    oda_numarasi integer NOT NULL,
    yatak_sayisi integer,
    kat_numarasi integer
);
    DROP TABLE public.oda;
       public         heap    postgres    false            �            1259    17839    ogrenci    TABLE       CREATE TABLE public.ogrenci (
    ogrenci_no integer NOT NULL,
    ogrenci_adi character varying(20) NOT NULL,
    ogrenci_soyad character varying(20) NOT NULL,
    dugum_tarihi date NOT NULL,
    telefon_no character varying(11) NOT NULL,
    oda_numarasi integer
);
    DROP TABLE public.ogrenci;
       public         heap    postgres    false            �            1259    17842    spor_salonu    TABLE     �   CREATE TABLE public.spor_salonu (
    gun date NOT NULL,
    saat time(4) without time zone,
    spor_turu character varying(30)
);
    DROP TABLE public.spor_salonu;
       public         heap    postgres    false            �            1259    17845    temizlik_personeli    TABLE     �   CREATE TABLE public.temizlik_personeli (
    kat_numarasi integer,
    muhaseip_tc character varying(11)
)
INHERITS (public.calisan);
 &   DROP TABLE public.temizlik_personeli;
       public         heap    postgres    false    209            �            1259    17848 	   yemekhane    TABLE     m   CREATE TABLE public.yemekhane (
    yemek_listesi character varying(50) NOT NULL,
    tarih date NOT NULL
);
    DROP TABLE public.yemekhane;
       public         heap    postgres    false            �            1259    17851    yemekhane_personeli    TABLE     l   CREATE TABLE public.yemekhane_personeli (
    muhasip_tc character varying(11)
)
INHERITS (public.calisan);
 '   DROP TABLE public.yemekhane_personeli;
       public         heap    postgres    false    209            �            1259    17854    yonetim_personeli    TABLE     j   CREATE TABLE public.yonetim_personeli (
    muhasip_tc character varying(11)
)
INHERITS (public.calisan);
 %   DROP TABLE public.yonetim_personeli;
       public         heap    postgres    false    209                      0    17816    calisan 
   TABLE DATA           d   COPY public.calisan (tc, isim, dugum_tarihi, telefon_no, adres, maas, maas_alma_tarihi) FROM stdin;
    public          postgres    false    209   y                 0    17819    etkinlik 
   TABLE DATA           T   COPY public.etkinlik (etkinlik_id, sunan_hoca, etkinlik_turu, aciklama) FROM stdin;
    public          postgres    false    210   �                 0    17824    kat 
   TABLE DATA           7   COPY public.kat (kat_numarasi, oda_sayisi) FROM stdin;
    public          postgres    false    211   �                 0    17827    kitablik 
   TABLE DATA           >   COPY public.kitablik (kitap_id, kitap_adi, yazar) FROM stdin;
    public          postgres    false    212   �                 0    17830    kural 
   TABLE DATA           3   COPY public.kural (kural_id, aciklama) FROM stdin;
    public          postgres    false    213   �                 0    17833    muhasebe_personeli 
   TABLE DATA           o   COPY public.muhasebe_personeli (tc, isim, dugum_tarihi, telefon_no, adres, maas, maas_alma_tarihi) FROM stdin;
    public          postgres    false    214   
                 0    17836    oda 
   TABLE DATA           G   COPY public.oda (oda_numarasi, yatak_sayisi, kat_numarasi) FROM stdin;
    public          postgres    false    215   '                 0    17839    ogrenci 
   TABLE DATA           q   COPY public.ogrenci (ogrenci_no, ogrenci_adi, ogrenci_soyad, dugum_tarihi, telefon_no, oda_numarasi) FROM stdin;
    public          postgres    false    216   D                 0    17842    spor_salonu 
   TABLE DATA           ;   COPY public.spor_salonu (gun, saat, spor_turu) FROM stdin;
    public          postgres    false    217   a                 0    17845    temizlik_personeli 
   TABLE DATA           �   COPY public.temizlik_personeli (tc, isim, dugum_tarihi, telefon_no, adres, maas, maas_alma_tarihi, kat_numarasi, muhaseip_tc) FROM stdin;
    public          postgres    false    218   ~                  0    17848 	   yemekhane 
   TABLE DATA           9   COPY public.yemekhane (yemek_listesi, tarih) FROM stdin;
    public          postgres    false    219   �       !          0    17851    yemekhane_personeli 
   TABLE DATA           |   COPY public.yemekhane_personeli (tc, isim, dugum_tarihi, telefon_no, adres, maas, maas_alma_tarihi, muhasip_tc) FROM stdin;
    public          postgres    false    220   �       "          0    17854    yonetim_personeli 
   TABLE DATA           z   COPY public.yonetim_personeli (tc, isim, dugum_tarihi, telefon_no, adres, maas, maas_alma_tarihi, muhasip_tc) FROM stdin;
    public          postgres    false    221   �             x������ � �            x������ � �            x������ � �            x������ � �            x������ � �            x������ � �            x������ � �            x������ � �            x������ � �            x������ � �             x������ � �      !      x������ � �      "      x������ � �     